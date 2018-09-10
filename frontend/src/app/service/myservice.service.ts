import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable()
export class MyserviceService {

  constructor(private http: HttpClient) { }

  public uploadFile(myFile: File):Observable<boolean>{
    // First of all we need to create a FormData object
    let myFormData = new FormData();
    // Then we are going to append the file into the FormData object
    myFormData.append("myFile",myFile,myFile.name);
    // Eventually let's consume the rest
    return this.http.put<boolean>("http://localhost:8080/api/v1/test",myFormData);
  }

}
