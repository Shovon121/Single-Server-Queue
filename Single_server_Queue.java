package single_server_queue;

public class Single_server_Queue {

    public static void main(String[] args) {

        //Given Value
        int totalRunTimeOfSimulation = 30;


        int[] arrivalTime = new int[7];
        int[] serviceTime = new int[7];
        int[] serviceTimeBegin = new int[7];
        int[] timeServiceEnd = new int[7];
        int[] customerWaitInQueue = new int[7];
        int[] idleTimeOfServer = new int[7];

        int customerWaitInQueueTotal = 0;
        int customerSpendsInSystem = 0;
        int timeServiceEndTotal = 0;
        int serviceTimeTotal = 0;
        int idleTimeOfServerTotal = 0;
        int count = 0;
        int sumOfArrivalAndServiceTime = 0;

        double avgWaitingTime = 0;
        double probabilityOfWaiting = 0;
        double probabilityOfIdleServer = 0;
        double avarageServiceTime = 0;

        for (int i = 0; i < serviceTimeBegin.length - 1; i++) {
            
            //Ganarate in Rendom Number
            arrivalTime[i] = (int) (Math.random() * 20);
            serviceTime[i] = (int) (Math.random() * 20);
            System.out.print("Position Of i: " + i + " Arrival Time: " + arrivalTime[i]);
            System.out.println(" Service Time: " + serviceTime[i]);
            
            //ServiceTime..
            serviceTimeTotal += serviceTime[i];
        }
        
        
        //Service Time Begin..

        for (int i = 0; i < serviceTimeBegin.length - 1; i++) {

            sumOfArrivalAndServiceTime = arrivalTime[i] + serviceTime[i];


            if (sumOfArrivalAndServiceTime < arrivalTime[i + 1]) {
                serviceTimeBegin[i] += arrivalTime[i];

            } else {

                serviceTimeBegin[i] += arrivalTime[i];
                serviceTimeBegin[i + 1] = sumOfArrivalAndServiceTime;
                //Waiting customer count...
                 count++;
                i++;

            }

        }

        System.out.println("");

        
        //Print of begin Time
        
        for (int i = 0; i < serviceTimeBegin.length - 1; i++) {
            System.out.println("Position Of i: " + i + " Service Time Begin:  " + serviceTimeBegin[i]);
        }

        for (int i = 0; i < serviceTime.length - 1; i++) {

            //ServiceTimeEnd
            timeServiceEnd[i] += serviceTime[i] + serviceTimeBegin[i];
            timeServiceEndTotal += timeServiceEnd[i];

            //Customer wait in queue
            customerWaitInQueue[i] = serviceTimeBegin[i] - arrivalTime[i];
            customerWaitInQueueTotal += customerWaitInQueue[i];

            //Customer Spends In System
            customerSpendsInSystem += timeServiceEnd[i] - arrivalTime[i];

        }
        System.out.println("");

        //Idle time of server 
        for (int i = 0; i < idleTimeOfServer.length - 1; i++) {

            if (arrivalTime[i + 1] > timeServiceEnd[i]) {
               
                idleTimeOfServer[i] = arrivalTime[i + 1] - timeServiceEnd[i];
                idleTimeOfServerTotal += idleTimeOfServer[i];
                System.out.println("Idle Time Of Server :" + idleTimeOfServer[i]);

            } else {
             
                idleTimeOfServerTotal += idleTimeOfServer[i];

                
               

            }

        }
        System.out.println("");

        System.out.println("ServiceTime Total: " + serviceTimeTotal);
        System.out.println("ServiceTimeEnd Total: " + timeServiceEndTotal);
        System.out.println("Customer Wait in queue total time: " + customerWaitInQueueTotal);
        System.out.println("Customer Spends In System Total Time: " + customerSpendsInSystem);
        System.out.println("Idle Time Of Server : " + idleTimeOfServerTotal);
        System.out.println("Total Customer Wait in Queue :" + count);
        //Now Calculate Result...
        //Avarage Waiting Time...  
        avgWaitingTime = (double) customerWaitInQueueTotal / arrivalTime.length;
        if (avgWaitingTime < 0) {
            avgWaitingTime = 0;
            System.out.println("Avarage Waiting Time: " + avgWaitingTime);
        } else {
            System.out.println("Avarage Waiting Time: " + avgWaitingTime);
        }

        //Probability Of Waiting..
        probabilityOfWaiting = (double) count / arrivalTime.length;
        System.out.println("Probability Of Waiting Time: " + probabilityOfWaiting);

        //Probability Of Idle Server..
        probabilityOfIdleServer = (double) idleTimeOfServerTotal / totalRunTimeOfSimulation;
        System.out.println("Probability Of Idl Time: " + probabilityOfIdleServer);

        //Avarage Servic Time..
        avarageServiceTime = (double) serviceTimeTotal / arrivalTime.length;
        System.out.println("Avarage Service Time: " + avarageServiceTime);

    }

}
