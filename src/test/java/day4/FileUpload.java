package day4;

import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;
public class FileUpload
{
    @Test
    public void fileupload()
    {
        //String auth ="Bearer eyJhbGciOiJkaXIiLCJlbmMiOiJBMjU2R0NNIiwidHlwIjoiSldUIn0..RV4U2KEDO7Xr28H3.VpVFyr13E96vVEEXj_0owVIOv25VL6DxlE8ZQ1lgLi4lsUcG8Q5Hbe8L5Fll-43V7fL-08bpfv1g4_GmyyzKeCjXXPseRRW2GOAUMYGX2wq2zIoJOfE1dythy9raukE0-r4TbT4RVqUDvzjLB92r_ycmh5_aK8syn4KsyFf6c5mWSNDTCRCNC0doQcSMpFEcacgHFXxfbpYmABSFOQFIRF18XD6QplgEZ1rouKUSLSK2cHYeV2sqAO-EPFisIalBavdqPZ6x8PIP.4eJeEwvq1cI4TYynLvUb6w";
        File aadhaar_front = new File("/Users/abhijitmondal/Documents/GitHub/Okc_API_Automation/target/aadhaar_front.jpg");
        File aadhaar_back = new File("/Users/abhijitmondal/Documents/GitHub/Okc_API_Automation/target/aadhaar_back.jpg");


                given()

                        .multiPart("front",aadhaar_front)
                        .multiPart("back",aadhaar_back)
                        .contentType("multipart/form-data")
                        .log().all()

                .when()
                        .post("https://kyc.staging.okcredit.io/verify/aadhaar")
                .then()
                        .statusCode(200)
                        .log().all();

    }
}
