/**
 * Java. Level 2  Lesson 1.
 *
 * @author Shangareev Rinat
 * @version dated 21.11.2017
 */

public class Main {
    public static void main(String[] args) {
        Obstacle[] obstacles = {new Cross(300), new Wall(25), new Cross(400)};
        Competitor[] competitors = {new Human("Bob"), new Cat("Barsik"), new Dog("Bobik")};
        Course course = new Course(obstacles);
        Team team = new Team("Winners", competitors);
        team.getInfo();
        course.doIt(team);
        team.showResults();
    }
}

   class Team {
        private String name;
        private Competitor[] competitors;

        public String getName() {
            return name;
        }

        private void setName(String name) {
            if (name != null && !name.isEmpty())
                this.name = name;
        }

        private void setCompetitors(Competitor[] competitors) {
            if (competitors.length == 4)
                this.competitors = competitors;
        }

        public Competitor[] getCompetitors() {
            return competitors;
        }

        Team(String name, Competitor[] competitors) {
            setName(name);
            this.competitors = competitors;
        }

        public void showResults() {
            for (Competitor competitor : competitors) {
                if (competitor.isOnDistance())
                    System.out.println("Team " + name + ": " + competitor.getName() + " - OK");
                else
                    System.out.println("Team " + name + ": " + competitor.getName() + " - FAILD");
            }
        }

        public void getInfo() {
            StringBuilder sb = new StringBuilder("Team ").append(name).append(": ");
            for (int i = 0; i < competitors.length; i++) {
                if (i == 0)
                    sb.append(competitors[i].getType()).append(" - ").append(competitors[i].getName());
                else
                    sb.append(", ").append(competitors[i].getType()).append(" - ").append(competitors[i].getName());
            }
            System.out.println(sb);
        }
    }

     abstract class Obstacle {
        public abstract void doIt(Competitor c);
    }


     class Water extends Obstacle {
        private int length;

        public Water(int length) {
            this.length = length;
        }

        @Override
        public void doIt(Competitor c) {
            c.swim(length);
        }
    }

     class Wall extends Obstacle {
        private int height;

        public Wall(int height) {
            this.height = height;
        }

        @Override
        public void doIt(Competitor c) {
            c.jump(height);
        }
    }

     class Human implements Competitor {
        protected String name;
        protected boolean active;
        protected int maxRunDistance;
        protected int maxJumpHeight;
        protected int maxSwimDistance;

        public String getName() {
            return name;
        }

        @Override
        public boolean isOnDistance() {
            return active;
        }

        public Human(String name) {
            this.name = name;
            this.active = true;
            this.maxRunDistance = 5000;
            this.maxJumpHeight = 100;
            this.maxSwimDistance = 2000;
        }

        @Override
        public void run(int distance) {
            if (distance <= maxRunDistance) {
                System.out.println(name + " Cross - OK");
            } else {
                System.out.println(name + " Cross - FAILED");
                active = false;
            }
        }

        @Override
        public void jump(int height) {
            if (height <= maxJumpHeight) {
                System.out.println(name + " Jump - OK");
            } else {
                System.out.println(name + " Jump - FAILED");
                active = false;
            }
        }

        @Override
        public void swim(int distance) {
            if (distance <= maxSwimDistance) {
                System.out.println(name + " Swim - OK");
            } else {
                System.out.println(name + " Swim - FAILED");
                active = false;
            }
        }

        public String getType() {
            return "Human";
        }
    }

     class Dog extends Animal {
        public Dog(String name) {
            super("Dog", name, 1000, 10, 10);
        }
    }

     class Cross extends Obstacle {
        private int length;

        public Cross(int length) {
            this.length = length;
        }

        @Override
        public void doIt(Competitor c) {
            c.run(length);
        }
    }

     class Course {
        private Obstacle[] obstacles;

        Course(Obstacle[] obstacles) {
            this.obstacles = obstacles;
        }

        public void doIt(Team team) {
            for (Competitor competitor : team.getCompetitors()) {
                for (Obstacle o : obstacles) {
                    o.doIt(competitor);
                    if (!competitor.isOnDistance())
                        break;
                }
            }
        }
    }

     interface Competitor {
        String getName();

        String getType();

        void run(int distance);

        void jump(int height);

        void swim(int distance);

        boolean isOnDistance();
    }

     class Cat extends Animal {
        public Cat(String name) {
            super("Cat", name, 500, 50, 0);
        }
    }

     abstract class Animal implements Competitor {
        protected String type;
        protected String name;
        protected boolean onDistance;
        protected int maxRunDistance;
        protected int maxJumpHeight;
        protected int maxSwimDistance;

        public String getName() {
            return name;
        }

        @Override
        public boolean isOnDistance() {
            return onDistance;
        }

        public Animal(String type, String name, int maxRunDistance, int maxJumpHeight, int maxSwimDistance) {
            this.type = type;
            this.name = name;
            this.onDistance = true;
            this.maxRunDistance = maxRunDistance;
            this.maxJumpHeight = maxJumpHeight;
            this.maxSwimDistance = maxSwimDistance;
        }

        @Override
        public void run(int distance) {
            if (distance <= maxRunDistance) {
                System.out.println(type + " " + name + " Cross - OK");
            } else {
                System.out.println(type + " " + name + " Cross - FAILED");
                onDistance = false;
            }
        }

        @Override
        public void jump(int height) {
            if (height <= maxJumpHeight) {
                System.out.println(type + " " + name + " Jump - OK");
            } else {
                System.out.println(type + " " + name + " Jump - FAILED");
                onDistance = false;
            }
        }

        @Override
        public void swim(int distance) {
            if (maxSwimDistance == 0) {
                System.out.println(type + " " + name + " Swim - ERROR");
                onDistance = false;
                return;
            }
            if (distance <= maxSwimDistance) {
                System.out.println(type + " " + name + " Swim - OK");
            } else {
                System.out.println(type + " " + name + " Swim - FAILED");
                onDistance = false;
            }
        }

        public String getType() {
            return type;
        }
    }




