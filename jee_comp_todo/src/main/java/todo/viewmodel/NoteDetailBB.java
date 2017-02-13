package todo.viewmodel;

import java.io.Serializable;
import java.util.Date;
import javax.enterprise.context.RequestScoped;

import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;

/**
 Backing bean for detail page (i.e. hold page data)
 *** NOTHING TO DO HERE 
 @author hajo
 */
@Named("notedetail")
@RequestScoped
public class NoteDetailBB implements Serializable {

    @Getter
    @Setter
    private Long id;
    @Getter
    @Setter
    private String text;
    @Setter
    @Getter
    private Date dateTime;
    @Setter
    @Getter
    private boolean done;
    
}
