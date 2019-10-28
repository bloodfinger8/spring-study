package imageboard.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository("imageboardDAO")
public class ImageboardDAOMybatis implements ImageboardDAO {

}
