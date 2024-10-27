package racingcar.service;

import racingcar.dto.RacingInfoDTO;
import racingcar.model.Car;
import racingcar.model.Winner;

import java.math.BigInteger;
import java.util.List;

public class WinnerService {

    public void findWinner(RacingInfoDTO racingInfoDTO) {
        BigInteger maxPosition = BigInteger.ZERO;

        Winner winner = new Winner();
        List<Car> winnerList = winner.getWinner();

        for (Car car : racingInfoDTO.getCarList()) {
            BigInteger curPosition = car.getPosition();

            if (curPosition.compareTo(maxPosition) > 0){
                maxPosition = curPosition;
                winnerList.clear();
                winnerList.add(car);
            }
            else if (maxPosition.compareTo(curPosition) == 0) {
                winnerList.add(car);
            }
        }

        // 최종 우승자 출력
        winner.printWinner();
    }
}