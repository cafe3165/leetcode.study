package leetcode.jianzhi2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Author:cafe3165
 * Date:2022-11-27
 */
public class T20isNumber {

    public enum NumberStatus {
        ERROR(-1),
        INIT(0),
        FUHAO(1),
        NUM(2),
        NUM_POST(9),
        DOT(3),
        E(4),
        E_FUHAO(5),
        E_NUM(6),

        NUM_DOT(7),
        BLANK(8),

        ;

        public static NumberStatus init() {
            return INIT;
        }

        public int status;

        NumberStatus(int status) {
            this.status = status;
        }

        public static boolean isEnd(NumberStatus status) {
            return NumberStatus.NUM.equals(status)
                    || NumberStatus.E_NUM.equals(status)
                    || NumberStatus.NUM_POST.equals(status)
                    || NumberStatus.BLANK.equals(status)
                    || NumberStatus.NUM_DOT.equals(status);
        }

    }

    //    "+,-" , "e,E", "1234567890", ".", " "
    public enum NumberConfig {
        BLANK("blank", Arrays.asList(NumberStatus.INIT), NumberStatus.INIT),
        BLANK_POST("blank_post", Arrays.asList(NumberStatus.NUM,  NumberStatus.BLANK,
                NumberStatus.NUM_DOT, NumberStatus.NUM_POST, NumberStatus.E_NUM), NumberStatus.BLANK),
        FU_HAO("fuhao", Arrays.asList(NumberStatus.INIT), NumberStatus.FUHAO),
        NUMBER("number", Arrays.asList(NumberStatus.INIT, NumberStatus.NUM, NumberStatus.FUHAO),
                NumberStatus.NUM),
        NUMBER_DOT("number_dot", Arrays.asList( NumberStatus.NUM),
                NumberStatus.NUM_DOT),
        NUMBER_POST("number_post", Arrays.asList(NumberStatus.DOT, NumberStatus.NUM_DOT, NumberStatus.NUM_POST), NumberStatus.NUM_POST),
//        NUMBER_DOT("number_dot", Arrays.asList(NumberStatus.NUM), NumberStatus.NUM_DOT),
        DOT("dot", Arrays.asList(NumberStatus.INIT, NumberStatus.FUHAO), NumberStatus.DOT),
        E("e", Arrays.asList(NumberStatus.NUM, NumberStatus.NUM_DOT, NumberStatus.NUM_POST), NumberStatus.E),
        E_FUHAO("e_fuhao", Arrays.asList(NumberStatus.E), NumberStatus.E_FUHAO),
        E_NUM("e_num", Arrays.asList(NumberStatus.E_FUHAO, NumberStatus.E, NumberStatus.E_NUM),NumberStatus.E_NUM),

        ;

        private String event;
        private List<NumberStatus> fromStatus;
        private NumberStatus toStatus;

        NumberConfig(String event, List<NumberStatus> fromStatus, NumberStatus toStatus) {
            this.event = event;
            this.fromStatus = fromStatus;
            this.toStatus = toStatus;
        }

        public String getEvent() {
            return event;
        }

        public List<NumberStatus> getFromStatus() {
            return fromStatus;
        }

        public  NumberStatus getToStatus() {
            return toStatus;
        }

        public static NumberConfig getConfigByEvent(String event) {
            return Stream.of(NumberConfig.values()).filter(config -> config.getEvent().equals(event)).findFirst().orElse(null);
        }



        public static NumberStatus evaluate(String event, NumberStatus status) {
            NumberConfig config  = NumberConfig.getConfigByEvent(event);
            List<NumberStatus> fromStatus = config.getFromStatus();
            if (!fromStatus.contains(status)) {
                return NumberStatus.ERROR;
            }
            return config.getToStatus();
        }
        public static String event(char cur, NumberStatus status) {

            if (cur == '.' && NumberConfig.DOT.getFromStatus().contains(status)) {
                return "dot";
            }
            if (cur == '.' && NumberConfig.NUMBER_DOT.getFromStatus().contains(status)) {
                return "number_dot";
            }

            if (cur == ' ' && NumberConfig.BLANK.getFromStatus().contains(status)) {
                return "blank";
            }
            if (cur == ' ' && NumberConfig.BLANK_POST.getFromStatus().contains(status)) {
                return "blank_post";
            }
            if (cur == 'e' || cur == 'E') {
                return "e";
            }
            if (NumberConfig.E_FUHAO.getFromStatus().contains(status) && (cur == '+' || cur == '-')) {
                return "e_fuhao";
            }
            if (NumberConfig.E_NUM.getFromStatus().contains(status) && (cur >= '0' && cur <= '9')) {
                return "e_num";
            }
            if (cur == '+' || cur == '-') {
                return "fuhao";
            }

            if (cur >= '0' && cur <= '9' && NumberConfig.NUMBER_POST.getFromStatus().contains(status)) {
                return "number_post";
            }
            if (cur >= '0' && cur <= '9' && NumberConfig.NUMBER.getFromStatus().contains(status)) {
                return "number";
            }
            return "error";
        }


    }


    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        NumberStatus status = NumberStatus.init();

        for(int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            String event = NumberConfig.event(cur, status);
            if ("error".equals(event)) {
                return false;
            }
            status = NumberConfig.evaluate(event, status);
            if (NumberStatus.ERROR.equals(status)) {
                return false;
            }
        }

        return NumberStatus.isEnd(status);

    }

    public static void main(String[] args) {

        T20isNumber t = new T20isNumber();
        System.out.println(t.isNumber("46.e3"));

    }
}
