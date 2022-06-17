package B_pacote_Apoo.U_Theards.Dominio.JavaMail;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Membros {
    private final Queue<String> emails = new ArrayBlockingQueue<>(10);
     private  boolean open = true;

     public boolean isOpen(){
         return open;
     }
     public int pendingEmails(){
         synchronized (emails){
             return emails.size();
         }
     }
     public void addEmail(String email){
         synchronized (this.emails){
              String threadName = Thread.currentThread().getName();
             System.out.println(threadName + "email adicionado na lista ");
              this.emails.add(email);
               this.emails.notifyAll();

         }
     }

     public String retriveEmail() throws InterruptedException {
         System.out.println(Thread.currentThread().getName() + "Chegando emails....");
          synchronized (this.emails){
              while (this.emails.size() == 0){
                  if (!open) break;
                  System.out.println(Thread.currentThread().getName() + "Nao possui email disponivel, entrando em modo de espera" );
                   this.emails.wait();
              }
              return this.emails.poll();
          }
     }
     public void close (){
          open = false;
          synchronized (this.emails){
              System.out.println(Thread.currentThread().getName() + " Nao possui emails");
          }

     }
}
