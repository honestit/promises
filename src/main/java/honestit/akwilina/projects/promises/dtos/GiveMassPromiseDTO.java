package honestit.akwilina.projects.promises.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Data
public class GiveMassPromiseDTO {

    private String what;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate lastSetDate;
    private FriendNameAndDeadline friendToAdd;
    private String removeFriend;
    private List<FriendNameAndDeadline> friends = new ArrayList<>();

    public void saveFriend() {
        if (this.friendToAdd != null) {
            friends.add(this.friendToAdd);
            lastSetDate = this.friendToAdd.getDeadlineDate();
        }
    }

    public void removeFriend() {
        if (removeFriend != null) {
            friends.removeIf(friend -> friend.getName().equals(removeFriend));
        }
    }

    @Data @AllArgsConstructor @NoArgsConstructor
    public static class FriendNameAndDeadline {

        private String name;
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private LocalDate deadlineDate;

        public static FriendNameAndDeadline valueOf(String value) {
            String[] values = value.split(";");
            return new FriendNameAndDeadline(values[0], LocalDate.parse(values[1], DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        }
    }

}
