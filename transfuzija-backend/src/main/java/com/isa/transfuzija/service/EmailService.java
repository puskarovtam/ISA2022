package com.isa.transfuzija.service;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.isa.transfuzija.model.RegisteredClient;
import com.isa.transfuzija.model.User;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	private Environment environment; /* koriscenje klase za ocitavanje vrednosti iz application.properties file-a */

	public void sendRegistrationEmail(User user) throws UnsupportedEncodingException {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "UTF-8");

		try {
			helper.setTo(user.getEmail());
			helper.setFrom(environment.getProperty("spring.mail.username"), "BLOOD DONOR");
			helper.setSubject("BLOOD DONOR - Email verifikacija");

			String message = "Pozdrav [[name]],<br>"
					+ "<p> Hvala Vam što ste napravili nalog na BLOOD DONOR servisu.</p>"
					+ "<p>Da kompletirate registraciju kliknite na link ispod da potvrdite Vašu email adresu. <br></p>"
					+ "<h4><a href=\"[[URL]]\">POTVRDI</a></h4>" + "<br>" + "S poštovanjem," + "<p>BLOOD DONOR tim</p>";
			String url = "http://localhost:4200/activate/" + user.getVerificationToken();
			message = message.replace("[[name]]", user.getName());
			message = message.replace("[[URL]]", url);

			helper.setText(message, true);

			System.out.println("Token je " + user.getVerificationToken());

		} catch (MessagingException e) {
			e.printStackTrace();
		}
		javaMailSender.send(mimeMessage);

	}
	
	public void sendAppointmentEmail(RegisteredClient client, byte[] qrCode) throws UnsupportedEncodingException {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		
		final InputStreamSource fileStreamSource = new ByteArrayResource(qrCode);

		try {
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
			helper.setTo(client.getEmail());
			helper.setFrom(environment.getProperty("spring.mail.username"), "BLOOD DONOR");
			helper.setSubject("BLOOD DONOR - Potvrda o rezervaciji termina");
			String message = "Pozdrav [[name]],<br>"
					+ "<h3>Hvala Vam što ste rezervisali termin na BLOOD DONOR servisu.</h3>"
					+ "<p>U prilog Vam šaljemo QR kod Vaše rezervacije. <br></p>"
					+ "S poštovanjem," + "<p>BLOOD DONOR tim</p>";
			message = message.replace("[[name]]", client.getName());		
			helper.addAttachment("rezervacija.png", fileStreamSource, "image/png");
			helper.setText(message, true);
			
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		javaMailSender.send(mimeMessage);
	}

}
