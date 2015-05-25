package nl.shop.srv;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import nl.shop.domain.Product;

@Stateless
//@ManagedBean
public class ProductService {

	@ShopDb
	@Inject
	EntityManager em;

	/**
	 * @return Geeft een lijst van alle producten terug.
	 */
	public List<Product> listProducts() {
		TypedQuery<Product> query = em.createQuery("select p from Product p",
				Product.class);
		return query.getResultList();
	}
}
