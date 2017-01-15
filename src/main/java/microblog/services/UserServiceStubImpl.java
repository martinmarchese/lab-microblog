package microblog.services;

import microblog.models.User;
import microblog.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserServiceStubImpl implements UserService
{
    @Override
    public boolean authenticate(String username, String password)
    {
        // Provide a sample password check: username == password
        return Objects.equals(username, password);
    }

    @Autowired
    private UserRepository userRepo;
    @Override
    public List<User> findAll()
    {
        return this.userRepo.findAll();
    }
    @Override
    public User findById(Long id)
    {
        return this.userRepo.findOne(id);
    }
    @Override
    public User create(User user)
    {
        return this.userRepo.save(user);
    }
    @Override
    public User edit(User user)
    {
        return this.userRepo.save(user);
    }
    @Override
    public void deleteById(Long id)
    {
        this.userRepo.delete(id);
    }
}