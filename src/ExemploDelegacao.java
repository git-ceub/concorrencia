

public class ExemploDelegacao {
    
	static int i = 0;
    
    public static void main(String[] args) {
        	Thread tr1 = new Thread(t1);
        	tr1.start();
            new Thread(t2).start();
            new Thread(t3).start();
    }

    private static void countMe(String name){
        i++;
        System.out.println("Current Counter is: " + i + ", updated by: " + name);
    }

    private static Runnable t1 = new Runnable() {
        public void run() {
                for(int i=0; i<5; i++){
                    countMe("t1");
                }
        }
    };

    private static Runnable t2 = new Runnable() {
        public void run() {
            for(int i=0; i<5; i++){
                countMe("t2");
            }
            //System.out.println("ppppppppp");
       }
    };
    
    private static Runnable t3 = new Runnable() {
        public void run() {
            for(int i=0; i<5; i++){
                countMe("t3");
            }
       }
    };
}