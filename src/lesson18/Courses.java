package lesson18;

public enum Courses {
    LECTURES {
        @Override
        public String toString() {
            return "Лекции";
        }
    },
    EXERCISES {
        @Override
        public String toString() {
            return "Упражнения";
        }
    },
    INTERMISSION {
        @Override
        public String toString() {
            return "Перерыв";
        }
    },
    DINNER_BREAK {
        @Override
        public String toString() {
            return "Обеденный перерыв";
        }
    },
    SOLUTIONS {
        @Override
        public String toString() {
            return "Решения";
        }
    };
}