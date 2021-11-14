package com.actonate.carrier_label_service.view_model.shprocket;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShiprocketTokenResponseViewModel {
    public Number id;

    public String first_name;

    public String last_name;

    public String email;

    public Number company_id;

    public String created_at;

    public String token;
}


//{"id":1285450,"first_name":"API","last_name":"USER","email":"admin@actonate.com","company_id":938833,"created_at":"2021-03-17 13:48:31","token":"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOjEyODU0NTAsImlzcyI6Imh0dHBzOi8vYXBpdjIuc2hpcHJvY2tldC5pbi92MS9leHRlcm5hbC9hdXRoL2xvZ2luIiwiaWF0IjoxNjM2NjMyNDUxLCJleHAiOjE2Mzc0OTY0NTEsIm5iZiI6MTYzNjYzMjQ1MSwianRpIjoiT0hERVZybVlUSFpiZFk5ZiJ9.fU4vj4tPcWGHAkmYCQG4sIAxE4O4dTWifDQUa-iUbxA"}