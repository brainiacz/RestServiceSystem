import com.dervan.module.Login.LoginController;
import com.dervan.module.model.dao.Member;

public class LoginControllerTest {
	
	
	public static void main(String[] args) {
		Member member = new Member();
		member.setUname("ashima123");
		member.setPass("roy123");
		
		Member mem = LoginController.getAutheticated(member);
		System.out.println(mem.getRole());
		System.out.println(mem.getEmail());
		System.out.println(mem.getFirstName());
		System.out.println(mem.getLastName());
		System.out.println(mem.getId());
	}

}
