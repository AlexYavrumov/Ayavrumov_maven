package HW_to_Lesson27;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Data
public class Students {

    private int id;
    private String name;
    private int group_id;

    @Override
    public String toString() {
        String result = "Student id=" + id + ", Name=" + name + ", groupId=" + group_id + "\n";
        return result;
    }
}