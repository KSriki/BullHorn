import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import customTools.DbPosts;
import model.Bhpost;

public class PostTest {

	@Test
	public void test() {
		List<Bhpost> bhposts = DbPosts.bhPost();
		assertEquals(bhposts != null, true);
		for(Bhpost p : bhposts){
			System.out.println("p stuff:");
			System.out.print(p.getPosttext());
			
		}
	}

}
