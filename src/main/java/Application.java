import com.ab.model.ActionType;
import com.ab.model.Resource;
import com.ab.model.Role;
import com.ab.model.User;
import com.ab.repository.DataRepository;
import com.ab.repository.DataRepositoryImpl;
import com.ab.service.RBACService;
import com.ab.service.RBACServiceImpl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Arpit Bhardwaj
 */
public class Application {
    public static void main(String[] args) {
        Resource resource1 = new Resource();
        resource1.setName("test1");
        resource1.setPath(System.getProperty("user.dir")+"/resources/test1.txt");
        //resource1.setAllowedAction(Arrays.asList(ActionType.READ, ActionType.WRITE, ActionType.DELETE));

        Resource resource2 = new Resource();
        resource2.setName("test2");
        resource2.setPath(System.getProperty("user.dir")+"/resources/test2.txt");
        //resource2.setAllowedAction(Arrays.asList(ActionType.READ,ActionType.DELETE));

        Role role1 = new Role();

        Map<String, List<ActionType>> resourceList1 = new HashMap<>();
        resourceList1.put(resource1.getName(), Arrays.asList(ActionType.READ, ActionType.WRITE, ActionType.DELETE));
        resourceList1.put(resource2.getName(), Arrays.asList(ActionType.READ));
        role1.setResourceList(resourceList1);

        Role role2 = new Role();

        Map<String, List<ActionType>> resourceList2 = new HashMap<>();
        resourceList2.put(resource1.getName(), Arrays.asList(ActionType.READ));
        resourceList2.put(resource2.getName(), Arrays.asList(ActionType.READ,ActionType.WRITE, ActionType.DELETE));
        role2.setResourceList(resourceList2);

        User user = new User("username1", "password1");
        user.addRole(role1);

        DataRepository dataRepo = new DataRepositoryImpl();
        dataRepo.addUser(user);

        RBACService service = new RBACServiceImpl(dataRepo);
        System.out.println(service.isAuthorized(user.getUserId(), "READ", "test1"));//true
        System.out.println(service.isAuthorized(user.getUserId(), "WRITE", "test2"));//false

    }
}
