//package midterm_prac;
//
//public abstract class BingoChecker implements Runnable {
//
//    BingoCard card;
//
//    protected BingoChecker(BingoCard card) {
//        this.card = card;
//    }
//
//    public static class BingoRowChecker extends BingoChecker {
//
//        int row;
//
//        public BingoRowChecker(BingoCard card, int row) {
//            super(card);
//            this.row = row;
//        }
//
//        @Override
//        public void run() {
//            for (int col = 0; col < 5; col++) {
//                while (!BingoGame.chosenNumbers.contains(this.card.nums[row][col])) {
//                    synchronized (BingoGame.result) {
//                        try {
//                            BingoGame.result.wait();
//                        } catch (InterruptedException e) {
//                            return;
//                        }
//                    }
//                }
//            }
//        }
//    }
//
//    public static class BingoColChecker extends BingoChecker {
//
//        int col;
//
//        public BingoColChecker(BingoCard card, int col) {
//            super(card);
//            this.col = col;
//        }
//
//        @Override
//        public void run() {
//            for (int row = 0; row < 5; row++) {
//                while (!BingoGame.chosenNumbers.contains(this.card.nums[row][col])) {
//                    synchronized (BingoGame.result) {
//                        try {
//                            BingoGame.result.wait();
//                        } catch (InterruptedException e) {
//                            return;
//                        }
//                    }
//                }
//            }
//        }
//    }
//}