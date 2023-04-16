package main.Control;

import main.Entities.AnimateEntities.DynamicEntities.*;
import main.Entities.AnimateEntities.DynamicEntities.Enemies.*;
import main.Graphics.Sprite;

import static main.Entities.Items.SpeedItem.*;

public class Move {
    private static int SpeedEntity(int x) {
        switch (x) {
            case 1:
                return 2;
            case 2:
                return 4;
            case 3:
                return 8;
            case 4:
                return 16;
            case 5:
                return 32;
            default:
                return 32;
        }
    };

    private static int setSpeedEntity(DynamicEntity animal) {
        if (animal instanceof Bomber) {
            if (speed < 4) {
                if (speed == 3)
                    return 2 * SpeedEntity(3);
                else
                    return speed * SpeedEntity(3);
            } else
                return SpeedEntity(5);
        } else {
            if (animal instanceof Ballom) {
                return SpeedEntity(1);
            } else {
                if (animal instanceof Doll || animal instanceof Pass || animal instanceof Ghost)
                    return SpeedEntity(3);
                else
                    return SpeedEntity(2);
            }
        }
    }

    public static void checkRun(DynamicEntity animal) {
        if (animal instanceof Bomber && animal.getCount() > 0) {
            setDirection(animal.getDirection(), animal, setSpeedEntity(animal));
            animal.setCount(animal.getCount() - 1);
        } else {
            if (animal.getCount() > 0) {
                setDirection(animal.getDirection(), animal, setSpeedEntity(animal));
                animal.setCount(animal.getCount() - 1);
            }
        }
    }

    private static void setDirection(String direction, DynamicEntity animal, int isMove) {
        switch (direction) {
            case "down":
                down_step(animal);
                animal.setY(animal.getY() + isMove);
                break;
            case "up":
                up_step(animal);
                animal.setY(animal.getY() - isMove);
                break;
            case "left":
                left_step(animal);
                animal.setX(animal.getX() - isMove);
                break;
            case "right":
                right_step(animal);
                animal.setX(animal.getX() + isMove);
                break;
        }
    }

    public static void down(DynamicEntity animal) {
        if (animal.getY() % Sprite.scaledSize == 0 && animal.getX() % Sprite.scaledSize == 0) {
            if (Blocked.block_down(animal) || animal instanceof Ghost || animal instanceof Ovapi
                    || animal instanceof Kondoria) {
                animal.setDirection("down");
                animal.setCount(32 / setSpeedEntity(animal));
                checkRun(animal);
            }
        }
    }

    public static void up(DynamicEntity animal) {
        if (animal.getY() % Sprite.scaledSize == 0 && animal.getX() % Sprite.scaledSize == 0) {
            if (Blocked.block_up(animal) || animal instanceof Ghost || animal instanceof Ovapi
                    || animal instanceof Kondoria) {
                animal.setDirection("up");
                animal.setCount(32 / setSpeedEntity(animal));
                checkRun(animal);
            }
        }
    }

    public static void left(DynamicEntity animal) {
        if (animal.getY() % Sprite.scaledSize == 0 && animal.getX() % Sprite.scaledSize == 0) {
            if (Blocked.block_left(animal) || animal instanceof Ghost || animal instanceof Ovapi
                    || animal instanceof Kondoria) {
                animal.setDirection("left");
                animal.setCount(32 / setSpeedEntity(animal));
                checkRun(animal);
            }
        }
    }

    public static void right(DynamicEntity animal) {
        if (animal.getY() % Sprite.scaledSize == 0 && animal.getX() % Sprite.scaledSize == 0) {
            if (Blocked.block_right(animal) || animal instanceof Ghost || animal instanceof Ovapi
                    || animal instanceof Kondoria) {
                animal.setDirection("right");
                animal.setCount(32 / setSpeedEntity(animal));
                checkRun(animal);
            }
        }
    }

    private static int Set1(DynamicEntity animal) {
        return 32 / setSpeedEntity(animal);
    }

    private static void down_step(DynamicEntity animal) {
        if (animal instanceof Bomber && animal.getY() % Set1(animal) == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.playerDown.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.playerDown_1.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.playerDown.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.playerDown_2.getFxImage());
                animal.setSwap(1);
            }
        }
        if (animal instanceof Ballom && animal.getY() % Set1(animal) == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.ballomRight_1.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.ballomRight_2.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.ballomRight_3.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.ballomRight_2.getFxImage());
                animal.setSwap(1);
            }
        }
        if (animal instanceof Oneal && animal.getY() % Set1(animal) == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.onealRight_1.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.onealRight_2.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.onealRight_3.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.onealRight_2.getFxImage());
                animal.setSwap(1);
            }
        }
        if (animal instanceof Doll && animal.getY() % Set1(animal) == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.dollRight_1.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.dollRight_2.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.dollRight_3.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.dollRight_2.getFxImage());
                animal.setSwap(1);
            }
        }
        if (animal instanceof Ghost && animal.getY() % Set1(animal) == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.ghostRight_1.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.ghostRight_2.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.ghostRight_3.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.ghostRight_2.getFxImage());
                animal.setSwap(1);
            }
        }
        if (animal instanceof Kondoria && animal.getY() % Set1(animal) == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.kondoriaRight_1.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.kondoriaRight_2.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.kondoriaRight_3.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.kondoriaRight_2.getFxImage());
                animal.setSwap(1);
            }
        }
        if (animal instanceof Minvo && animal.getY() % Set1(animal) == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.minvoRight_1.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.minvoRight_2.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.minvoRight_3.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.minvoRight_2.getFxImage());
                animal.setSwap(1);
            }
        }
        if (animal instanceof Ovapi && animal.getY() % Set1(animal) == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.ovapiRight_1.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.ovapiRight_2.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.ovapiRight_3.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.ovapiRight_2.getFxImage());
                animal.setSwap(1);
            }
        }
        if (animal instanceof Pass && animal.getY() % Set1(animal) == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.passRight_1.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.passRight_2.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.passRight_3.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.passRight_2.getFxImage());
                animal.setSwap(1);
            }
        }
    }

    private static void up_step(DynamicEntity animal) {
        if (animal instanceof Bomber && animal.getY() % Set1(animal) == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.playerUp.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.playerUp_1.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.playerUp.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.playerUp_2.getFxImage());
                animal.setSwap(1);
            }
        }
        if (animal instanceof Ballom && animal.getY() % Set1(animal) == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.ballomLeft_1.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.ballomLeft_2.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.ballomLeft_3.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.ballomLeft_2.getFxImage());
                animal.setSwap(1);
            }
        }
        if (animal instanceof Oneal && animal.getY() % Set1(animal) == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.onealLeft_1.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.onealLeft_2.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.onealLeft_3.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.onealLeft_2.getFxImage());
                animal.setSwap(1);
            }
        }
        if (animal instanceof Doll && animal.getY() % Set1(animal) == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.dollLeft_1.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.dollLeft_2.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.dollLeft_3.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.dollLeft_2.getFxImage());
                animal.setSwap(1);
            }
        }
        if (animal instanceof Ghost && animal.getY() % Set1(animal) == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.ghostLeft_1.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.ghostLeft_2.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.ghostLeft_3.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.ghostLeft_2.getFxImage());
                animal.setSwap(1);
            }
        }
        if (animal instanceof Kondoria && animal.getY() % Set1(animal) == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.kondoriaLeft_1.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.kondoriaLeft_2.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.kondoriaLeft_3.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.kondoriaLeft_2.getFxImage());
                animal.setSwap(1);
            }
        }
        if (animal instanceof Minvo && animal.getY() % Set1(animal) == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.minvoLeft_1.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.minvoLeft_2.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.minvoLeft_3.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.minvoLeft_2.getFxImage());
                animal.setSwap(1);
            }
        }
        if (animal instanceof Ovapi && animal.getY() % Set1(animal) == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.ovapiLeft_1.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.ovapiLeft_2.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.ovapiLeft_3.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.ovapiLeft_2.getFxImage());
                animal.setSwap(1);
            }
        }
        if (animal instanceof Pass && animal.getY() % Set1(animal) == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.passLeft_1.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.passLeft_2.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.passLeft_3.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.passLeft_2.getFxImage());
                animal.setSwap(1);
            }
        }
    }

    private static void left_step(DynamicEntity animal) {
        if (animal instanceof Bomber && animal.getX() % Set1(animal) == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.playerLeft.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.playerLeft_1.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.playerLeft.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.playerLeft_2.getFxImage());
                animal.setSwap(1);
            }
        }
        if (animal instanceof Ballom && animal.getY() % Set1(animal) == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.ballomLeft_1.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.ballomLeft_2.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.ballomLeft_3.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.ballomLeft_2.getFxImage());
                animal.setSwap(1);
            }
        }
        if (animal instanceof Oneal && animal.getY() % Set1(animal) == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.onealLeft_1.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.onealLeft_2.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.onealLeft_3.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.onealLeft_2.getFxImage());
                animal.setSwap(1);
            }
        }
        if (animal instanceof Doll && animal.getY() % Set1(animal) == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.dollLeft_1.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.dollLeft_2.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.dollLeft_3.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.dollLeft_2.getFxImage());
                animal.setSwap(1);
            }
        }
        if (animal instanceof Ghost && animal.getY() % Set1(animal) == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.ghostLeft_1.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.ghostLeft_2.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.ghostLeft_3.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.ghostLeft_2.getFxImage());
                animal.setSwap(1);
            }
        }
        if (animal instanceof Kondoria && animal.getY() % Set1(animal) == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.kondoriaLeft_1.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.kondoriaLeft_2.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.kondoriaLeft_3.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.kondoriaLeft_2.getFxImage());
                animal.setSwap(1);
            }
        }
        if (animal instanceof Minvo && animal.getY() % Set1(animal) == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.minvoLeft_1.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.minvoLeft_2.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.minvoLeft_3.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.minvoLeft_2.getFxImage());
                animal.setSwap(1);
            }
        }
        if (animal instanceof Ovapi && animal.getY() % Set1(animal) == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.ovapiLeft_1.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.ovapiLeft_2.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.ovapiLeft_3.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.ovapiLeft_2.getFxImage());
                animal.setSwap(1);
            }
        }
        if (animal instanceof Pass && animal.getY() % Set1(animal) == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.passLeft_1.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.passLeft_2.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.passLeft_3.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.passLeft_2.getFxImage());
                animal.setSwap(1);
            }
        }
    }

    public static void right_step(DynamicEntity animal) {
        if (animal instanceof Bomber && animal.getX() % Set1(animal) == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.playRight.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.playerRight_1.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.playRight.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.playerRight_2.getFxImage());
                animal.setSwap(1);
            }
        }

        if (animal instanceof Ballom && animal.getY() % Set1(animal) == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.ballomRight_1.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.ballomRight_2.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.ballomRight_3.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.ballomRight_2.getFxImage());
                animal.setSwap(1);
            }
        }
        if (animal instanceof Oneal && animal.getY() % Set1(animal) == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.onealRight_1.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.onealRight_2.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.onealRight_3.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.onealRight_2.getFxImage());
                animal.setSwap(1);
            }
        }
        if (animal instanceof Doll && animal.getY() % Set1(animal) == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.dollRight_1.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.dollRight_2.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.dollRight_3.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.dollRight_2.getFxImage());
                animal.setSwap(1);
            }
        }
        if (animal instanceof Ghost && animal.getY() % Set1(animal) == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.ghostRight_1.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.ghostRight_2.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.ghostRight_3.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.ghostRight_2.getFxImage());
                animal.setSwap(1);
            }
        }
        if (animal instanceof Kondoria && animal.getY() % Set1(animal) == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.kondoriaRight_1.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.kondoriaRight_2.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.kondoriaRight_3.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.kondoriaRight_2.getFxImage());
                animal.setSwap(1);
            }
        }
        if (animal instanceof Minvo && animal.getY() % Set1(animal) == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.minvoRight_1.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.minvoRight_2.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.minvoRight_3.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.minvoRight_2.getFxImage());
                animal.setSwap(1);
            }
        }
        if (animal instanceof Ovapi && animal.getY() % Set1(animal) == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.ovapiRight_1.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.ovapiRight_2.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.ovapiRight_3.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.ovapiRight_2.getFxImage());
                animal.setSwap(1);
            }
        }
        if (animal instanceof Pass && animal.getY() % Set1(animal) == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.passRight_1.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.passRight_2.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.passRight_3.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.passRight_2.getFxImage());
                animal.setSwap(1);
            }
        }
    }
}
