package microblog.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PostForm
{
    @NotNull
    @Size(min=2, max=30, message = "Title size should be in the range [2...30]")
    private String title;

    @NotNull
    private String body;

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getBody() { return body; }

    public void setBody(String body) { this.body = body; }

}
