package lk.ijse.absd.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

@RestController
@CrossOrigin
@RequestMapping("api/v1/test")
public class MyController {

    /**
     * In order to work with HTTP PUT method, you need to create a custom multipart resolver
     *
     * @param myFile
     * @param isFile
     * @param multipartFile2
     * @return
     */
    @PutMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean saveFile(@RequestPart("myFile") MultipartFile myFile,
                            @RequestPart("myFile") byte[] isFile,
                            @RequestParam("myFile") MultipartFile multipartFile2) {
        /*
         * There are two ways that we can obtain this value, but in all cases we need to use
         * @RequestPart annotation.
         * 1. Byte Array ( byte [] )
         * 2. MultipartFile ( Spring way )
         */

        /*
         * It is important to note that Apache Common File Upload is not going to work with
         * javax.servlet.http.Part
         */

        System.out.println(isFile);

        /**
         * It is important to note that you can also use @RequestParam annotation if you need
         * But with that you can't retrieve the data as a byte array
         */

        System.out.println(multipartFile2.getOriginalFilename());

        try {
            // Let's get the project location
            String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile().getAbsolutePath();
            // Let's create a folder there for uploading purposes, if not exists
            File uploadsDir = new File(projectPath + "/uploads");
            uploadsDir.mkdir();
            // It is time to transfer the file into the newly created dir
            myFile.transferTo(new File(uploadsDir.getAbsolutePath() + "/" + myFile.getOriginalFilename()));
            return true;
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

}
