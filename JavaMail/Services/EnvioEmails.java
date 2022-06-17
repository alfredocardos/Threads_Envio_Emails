package B_pacote_Apoo.U_Theards.Dominio.JavaMail;

public class EnvioEmails implements Runnable{
     private final Membros membros;

    public EnvioEmails(Membros membros) {
        this.membros = membros;
    }

    @Override
    public void run() {
         String threadNme = Thread.currentThread().getName();
        System.out.println(threadNme + "Inicio para envii de email ");
        while (membros.isOpen() || membros.pendingEmails() > 0) {
            try {
                String retriveEmail = membros.retriveEmail();
                if (retriveEmail == null ) continue;
                System.out.println(threadNme + "enviando email para "+ retriveEmail);
                Thread.sleep(2000);
                System.out.println(threadNme + "enviou email para " + retriveEmail);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        System.out.println("Emails enviados com sucesso!");

    }
}
