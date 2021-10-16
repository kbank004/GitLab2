package edu.odu.cs.cs350;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class TestMagazine {
    LocalDate date = LocalDate.of(2021,10,11);

    @Test
    public void testMagazineDefaultConstructor(){
        Magazine mag = new Magazine();
        assertThat(mag.getTitle(), is(""));
        assertThat(mag.getPublicationDate(), is(LocalDate.now()));
        assertThat(mag.startingPages().size(), is(0));
    }
    @Test
    public void testMagazineConstructor(){
        Magazine mag = new Magazine("My Very Interesting Magazine", date);

        assertThat(mag.getTitle(), is("My Very Interesting Magazine"));
        assertThat(mag.getPublicationDate(), equalTo(date));
    }
    @Test
    public void testMagazineSetTitle(){
        Magazine mag = new Magazine("My Very Interesting Magazine", date);
        mag.setTitle("A Very Boring Magazine");
        assertThat(mag.getTitle(), is("A Very Boring Magazine"));
    }

    @Test
    public void testMagazineSetDate(){
        Magazine mag = new Magazine("My Very Interesting Magazine", date);

        LocalDate newdate = LocalDate.of(2001,02,01);
        mag.setPublicationDate(newdate);
        assertThat(mag.getPublicationDate(),is(newdate));
    }


    @Test
    public void testMagazineArticleCount(){
        Magazine mag = new Magazine("My Very Interesting Magazine", date);

        assertThat(mag.numArticles(), is(0));
        Article art = new Article("My Article", "Shakespeare");
        mag.addArticle(1, art);
        assertThat(mag.numArticles(), is(1));
        mag.addArticle(4, art);
        assertThat(mag.numArticles(), is(2));

    }

    @Test
    public void testMagazineEquivalence(){
        Magazine mag1 = new Magazine("GamerMag", date);
        Magazine mag2 = new Magazine("GamerMag", date);
        assertThat(mag1.equals(mag2), is(true));
    }
    @Test
    public void testMagazineClone(){
        Magazine mag1 = new Magazine("Penguin Life", date);
        Magazine mag2 = (Magazine) mag1.clone();
        assertThat(mag1.getTitle(), is(mag2.getTitle()));
        assertThat(mag1.getPublicationDate(), is(mag2.getPublicationDate()));
        assertThat(mag1.numArticles(), is(mag2.numArticles()));
        assertThat(mag1.startingPages(), is(mag2.startingPages()));
    }
    @Test
    public void testMagazineHashCode(){
        Magazine mag1 = new Magazine("Another boring magazine", date);
        Magazine mag2 = new Magazine("Another boring magazine", date.minusDays(1));
        assertThat(mag1.hashCode(), not(mag2.hashCode()));
        Magazine mag3 = new Magazine("Another boring magazine", date);
        assertThat(mag1.hashCode(), is(mag3.hashCode()));
    }
    @Test
    public void testMagazineToString(){
        Magazine mag = new Magazine("My Very Interesting Magazine", date);
        assertThat(mag.toString(), not(nullValue()));
    }
    @Test
    public void testMagazineStartPages(){
        Magazine mag = new Magazine("My Very Interesting Magazine", date);
        Article art = new Article("Penguins can, in fact, fly!", "PenguinConspiracist");
        mag.addArticle(1,art);
        assertThat(mag.startingPages().size(), is(1));

    }

    @Test
    public void testMagazineGetArticle(){
        Magazine mag = new Magazine("My Very Interesting Magazine", date);
        Article art = new Article("My Article", "Shakespeare");
        mag.addArticle(3, art);
        assertThat(mag.getArticle(3), is(art));

    }

}
