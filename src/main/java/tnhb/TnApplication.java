package tnhb;


import getChangePassword.GetChangePasswordController;
import getEmailOtp.GetEmailOtpController;
import getUser.UserController;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import controllers.DataMonitoringController;
import controllers.FileController;


@SpringBootApplication
@ComponentScan(basePackageClasses = UserController.class)
@ComponentScan(basePackageClasses = DataMonitoringController.class)
@ComponentScan(basePackageClasses = GetChangePasswordController.class)
@ComponentScan(basePackageClasses = GetEmailOtpController.class)
@ComponentScan(basePackageClasses = FileController.class)

@EnableTransactionManagement

@EnableJpaRepositories("repos")
@EntityScan("models")
public class TnApplication {
  public static void main(String[] args) {
    SpringApplication.run(TnApplication.class, args);
  }
}