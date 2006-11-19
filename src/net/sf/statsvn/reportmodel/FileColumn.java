/*
	StatCvs - CVS statistics generation 
	Copyright (C) 2002  Lukasz Pekacki <lukasz@pekacki.de>
	http://statcvs.sf.net/
    
	This library is free software; you can redistribute it and/or
	modify it under the terms of the GNU Lesser General Public
	License as published by the Free Software Foundation; either
	version 2.1 of the License, or (at your option) any later version.

	This library is distributed in the hope that it will be useful,
	but WITHOUT ANY WARRANTY; without even the implied warranty of
	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
	Lesser General Public License for more details.

	You should have received a copy of the GNU Lesser General Public
	License along with this library; if not, write to the Free Software
	Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
    
	$RCSfile: FileColumn.java,v $
	$Date: 2003/06/04 13:20:16 $
*/
package net.sf.statsvn.reportmodel;

import net.sf.statsvn.Messages;
import net.sf.statsvn.model.VersionedFile;
import net.sf.statsvn.renderer.TableCellRenderer;

/**
 * A table column containing files
 * 
 * @author Richard Cyganiak <rcyg@gmx.de>
 * @version $Id: FileColumn.java,v 1.2 2003/06/04 13:20:16 cyganiak Exp $
 */
public class FileColumn extends GenericColumn {
	private boolean withIcon = false;

	/**
	 * Creates a new directory column
	 */
	public FileColumn() {
		super(Messages.getString("COLUMN_FILE"));
	}

	/**
	 * @see net.sf.statsvn.reportmodel.Column#renderCell
	 */
	public void renderCell(final int rowIndex, final TableCellRenderer renderer) {
		renderer.renderFileCell((VersionedFile) getValue(rowIndex), withIcon);
	}

	/**
	 * Specifies if each cell should be rendered with an icon representing
	 * the file
	 * @param withIcon render with icon? 
	 */
	public void setWithIcon(final boolean withIcon) {
		this.withIcon = withIcon;
	}
}