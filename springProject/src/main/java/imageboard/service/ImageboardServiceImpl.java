package imageboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import imageboard.bean.ImageboardDTO;
import imageboard.dao.ImageboardDAO;

@Service(value="imageboardService")
public class ImageboardServiceImpl implements ImageboardService {
	
	@Autowired
	private ImageboardDAO imageboardDAO;
	
	@Override
	public void imageboardWrite(ImageboardDTO imageboardDTO) {
		imageboardDAO.imageboardWrite(imageboardDTO);
	}

}
