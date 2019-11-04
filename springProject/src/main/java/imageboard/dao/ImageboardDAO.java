package imageboard.dao;

import java.util.List;
import java.util.Map;

import imageboard.bean.ImageboardDTO;

public interface ImageboardDAO {

	void imageboardWrite(ImageboardDTO imageboardDTO);

	List<ImageboardDTO> getImageboardList(Map<String, Integer> map);

	void imageboardDelete(Map<String, String[]> map);

	ImageboardDTO getImageboardView(int seq);

	int getImageboardTotalA();

	

}
