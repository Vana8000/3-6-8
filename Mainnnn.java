import java.util.*;

class User {
    private String name;
    private Integer age;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return name + ", возраст " + age + " лет";
    }
}

public class Mainnnn {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, List<User>> usersByAge = new HashMap<>();

        for (int i = 1; i <= 5; i++) {
            System.out.println("Введите имя пользователя " + i);
            String name = scanner.nextLine();
            System.out.println("Введите возраст пользователя " + i);
            int age = scanner.nextInt();
            scanner.nextLine();

            User user = new User(name, age);

            List<User> users = usersByAge.get(user.getAge());
            if (users == null) {
                users = new ArrayList<>();
            }
            users.add(user);
            usersByAge.put(user.getAge(), users);
        }

        System.out.println("Введите требуемый возраст");
        int requiredAge = scanner.nextInt();
        scanner.nextLine();

        List<User> requiredUsers = usersByAge.get(requiredAge);
        if (requiredUsers != null) {
            requiredUsers.sort(Comparator.comparing(User::getName));
            for (User user : requiredUsers) {
                System.out.println(user.toString());
            }
        } else {
            System.out.println("Пользователь с возрастом " + requiredAge + " не найден");
        }
    }
}