package microblog.services;

import microblog.models.Post;
import microblog.models.User;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class PostServiceStubImpl implements PostService
{
    private List<Post> posts = new ArrayList<Post>()
    {{
        /*add(new Post("First Post", "<p>Line #1.</p><p>Line #2</p>"));
        add(new Post("Second Post","Second post content:<ul><li>line 1</li><li>line 2</li></p>"));
        add(new Post("Post #3", "<p>The post number 3 nice</p>"));
        add(new Post("Forth Post", "<p>Not interesting post</p>"));
        add(new Post("Post Number 5", "<p>Just posting</p>"));
        add(new Post("Sixth Post", "<p>Another interesting post</p>"));*/
    }};

    @Override
    public List<Post> findAll()
    {
        return this.posts;
    }

    @Override
    public List<Post> findLatest5()
    {
        return this.posts.stream()
                .sorted((a, b) -> b.getDate().compareTo(a.getDate()))
                .limit(5)
                .collect(Collectors.toList());
    }

    @Override
    public Post findById(Long id)
    {
        return this.posts.stream()
                .filter(p -> Objects.equals(p.getId(), id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Post create(Post post)
    {
        post.setId(this.posts.stream().mapToLong(
                p -> p.getId()).max().getAsLong() + 1);
        this.posts.add(post);
        return post;
    }

    @Override
    public Post edit(Post post)
    {
        for (int i = 0; i < this.posts.size(); i++)
        {
            if (Objects.equals(this.posts.get(i).getId(), post.getId()))
            {
                this.posts.set(i, post);
                return post;
            }
        }
        throw new RuntimeException("Post not found: " + post.getId());
    }

    @Override
    public void deleteById(Long id)
    {
        for (int i = 0; i < this.posts.size(); i++)
        {
            if (Objects.equals(this.posts.get(i).getId(), id))
            {
                this.posts.remove(i);
                return;
            }
        }
        throw new RuntimeException("Post not found: " + id);
    }
}