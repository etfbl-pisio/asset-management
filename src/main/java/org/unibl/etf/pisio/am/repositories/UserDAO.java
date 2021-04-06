package org.unibl.etf.pisio.am.repositories;

import org.springframework.stereotype.Repository;
import org.unibl.etf.pisio.am.models.User;

import java.util.Arrays;
import java.util.List;

@Repository
public class UserDAO {

    public List<User> getAll(){
        return Arrays.asList(new User("Marko","Markovic"),new User("Marija","Maric"));
    }
}
