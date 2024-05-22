package chapter04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
//@Component
public class BoardServiceImpl implements BoardService {
	@Autowired
	BoardDAO dao;
	
	@Override
	public void list() {
		dao.list();
	}

}
