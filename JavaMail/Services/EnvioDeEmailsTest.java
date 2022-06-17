package B_pacote_Apoo.U_Theards.Dominio.JavaMail;

import javax.swing.*;

public class EnvioDeEmailsTest {
    public static void main(String[] args) {
        Membros membros = new Membros();
        Thread ip_01 = new Thread(new EnvioEmails(membros), "Ip_01");
        Thread ip_02 = new Thread(new EnvioEmails(membros), "Ip_02");
        ip_01.start();
        ip_02.start();
        while (true){
            String digite_seu_email = JOptionPane.showInputDialog("Digite seu email");
             if (digite_seu_email == null || digite_seu_email.isEmpty()){
                 membros.close();
                 break;
             }
             membros.addEmail(digite_seu_email);
        }
    }
}
