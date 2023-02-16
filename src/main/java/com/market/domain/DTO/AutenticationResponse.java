package com.market.domain.DTO;

public class AutenticationResponse {
    private String jwt;

    public AutenticationResponse(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
