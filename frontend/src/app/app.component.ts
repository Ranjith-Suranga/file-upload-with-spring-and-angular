import {Component, ElementRef, ViewChild} from '@angular/core';
import {MyserviceService} from "./service/myservice.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  @ViewChild("myFile")
  myFile: ElementRef;

  constructor(private myService: MyserviceService) {

  }

  uploadFile(): void {
    // Let's extract the file
    let file = this.myFile.nativeElement.files[0];
    // Check whether there is a file exists
    if (file) {
      // If so, let's upload it
      this.myService.uploadFile(file).subscribe(result=>{

        if (result){
          alert("Upload successfully");
        }else{
          alert("Failed to upload");
        }
      });
    }
  }

}
