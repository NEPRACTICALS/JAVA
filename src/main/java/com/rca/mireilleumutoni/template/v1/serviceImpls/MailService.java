package com.rca.mireilleumutoni.template.v1.serviceImpls;

import com.rca.mireilleumutoni.template.v1.models.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@RequiredArgsConstructor
public class MailService {

    private final JavaMailSender mailSender;
    private final TemplateEngine templateEngine;

    @Async
    public void sendTransactionEmail(Customer customer, float amount, String transactionType, String subject) {
        Context context = new Context();
        context.setVariable("customerName", customer.getFirstName());
        context.setVariable("transactionType", transactionType);
        context.setVariable("amount", amount);

        String process = templateEngine.process("transaction-notification", context);

        sendEmail(customer.getEmail(), subject, process);
    }

    public void sendEmail(String to, String subject, String content) {
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText(content, true);
            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            // Handle exception
            e.printStackTrace();
        }
    }
}
