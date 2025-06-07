package service.rsv;

import dao.rsv.ReservationDAO;
import model.rsv.ReservationVO;

public class ReservationServiceImpl implements ReservationService{
    ReservationDAO rdao = new ReservationDAO();

    @Override
    public int reservation(ReservationVO reservationVO) {
        System.out.println("서비스(서비스 구현체impl)-ReservationServiceImpl");

        return rdao.insertReservation(reservationVO);
    }
}
