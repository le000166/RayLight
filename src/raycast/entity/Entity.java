package raycast.entity;

import raycast.entity.property.Drawable;

public interface Entity {
	
	public Drawable<?> getDrawable();
	public boolean isDrawable();

}
