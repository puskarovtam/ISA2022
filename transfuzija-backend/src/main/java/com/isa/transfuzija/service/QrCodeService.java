package com.isa.transfuzija.service;

public interface QrCodeService {

	byte[] generateQrCode(String qrCodeContent, int width, int height);

}
