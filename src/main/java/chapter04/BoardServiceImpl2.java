package chapter04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class BoardServiceImpl2 implements BoardService {
	@Autowired
	BoardDAO dao;
	
	@Override
	public void list() {
		System.out.println("좀 다르게");
		dao.list();
	}

}
