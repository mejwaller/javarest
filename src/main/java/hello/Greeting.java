package hello;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Greeting {

    private final long id;
    private final String content;
	private final List<String> phrases;

    public Greeting(long id, String content) throws IOException{
        this.id = id;
        this.content = content;
        this.phrases = new ArrayList<String>();
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("phrases.txt");
        
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        //StringBuffer sb = new StringBuffer();
        String line;
        while ((line = br.readLine()) != null) 
        {
          //sb.append(line);
          //System.out.println(line);
          this.phrases.add(line);
        }
        br.close();
        isr.close();
        is.close();
        
        
        
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
