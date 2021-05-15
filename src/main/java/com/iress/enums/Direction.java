package com.iress.enums;

public enum Direction {

    NORTH {
        @Override
        public Direction trunLeft() {
            return WEST;
        }

        @Override
        public Direction trunRight() {
            return EAST;
        }

        @Override
        public String getDescription() {
            return "NORTH";
        }
    },
    EAST {
        @Override
        public Direction trunLeft() {
            return NORTH;
        }

        @Override
        public Direction trunRight() {
            return SOUTH;
        }

        @Override
        public String getDescription() {
            return "EAST";
        }
    },
    SOUTH {
        @Override
        public Direction trunLeft() {
            return EAST;
        }

        @Override
        public Direction trunRight() {
            return WEST;
        }

        @Override
        public String getDescription() {
            return "SOUTH";
        }
    },
    WEST {
        @Override
        public Direction trunLeft() {
            return SOUTH;
        }

        @Override
        public Direction trunRight() {
            return NORTH;
        }

        @Override
        public String getDescription() {
            return "WEST";
        }
    };

    public abstract Direction trunLeft();
    public abstract Direction trunRight();
    public abstract String getDescription();


}
