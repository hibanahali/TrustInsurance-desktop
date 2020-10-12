package Service;



// Install the Java helper library from twilio.com/docs/libraries/java
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.twiml.Sms;
import com.twilio.type.PhoneNumber;

public class SmsService {
    // Find your Account Sid and Auth Token at twilio.com/console
    public static final String ACCOUNT_SID =
            "AC9f956c87e63216abe635f4f3fa143a50";
    public static final String AUTH_TOKEN =
            "44400d3838a99fc8c7b0081c4d0d2055";
    public static int x;
  
   public void sendSms(int x) {
           

      
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message
                .creator(new PhoneNumber("+21655437493"), // to
                        new PhoneNumber("+14129233325"), // from
                      Integer.toString(x))
                .create();


        System.out.println(message.getSid());
    }
    
}