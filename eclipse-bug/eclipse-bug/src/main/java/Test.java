import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.joda.time.LocalDate;

@Entity
@TypeDef( name = "localDate", typeClass = org.jadira.usertype.dateandtime.joda.PersistentLocalDate.class )
@Table( name = "events" )
public class Test {

    @Type( type = "localDate" )
    @Column( name = "dayt" )
    private LocalDate date;

    /**
     * @return the date
     */
    public LocalDate getDate () {
        return this.date;
    }

    /**
     * @param date
     *            the date to set
     */
    public void setDate ( LocalDate date ) {
        this.date = date;
    }

}
