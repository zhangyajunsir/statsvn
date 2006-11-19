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
    
	$RCSfile: DirectoriesForAuthorTableReport.java,v $
	$Date: 2003/12/17 23:12:35 $
*/
package net.sf.statsvn.reports;

import net.sf.statsvn.Messages;
import net.sf.statsvn.model.Author;
import net.sf.statsvn.model.Repository;
import net.sf.statsvn.reportmodel.DirectoryColumn;
import net.sf.statsvn.reportmodel.Table;

/**
 * Table report which creates a table containing directories to which
 * a specified author has committed changes, and their respective
 * number of changes and LOC.
 * 
 * @author Richard Cyganiak <rcyg@gmx.de>
 * @version $Id: DirectoriesForAuthorTableReport.java,v 1.2 2003/12/17 23:12:35 cyganiak Exp $
 */
public class DirectoriesForAuthorTableReport extends AbstractLocTableReport 
		implements TableReport {

	private Author author;
	private Table table = null;

	/**
	 * Creates a table report containing directories to which a specified
	 * author has committed changes, and their respective number of changes
	 * and LOC.
	 * @param content the version control source data
	 * @param author an author
	 */
	public DirectoriesForAuthorTableReport(final Repository content,
			final Author author) {
		super(content);
		this.author = author;
	}
	
	/**
	 * @see net.sf.statsvn.reports.TableReport#calculate()
	 */
	public void calculate() {
		calculateChangesAndLinesPerDirectory(author.getRevisions());
		table = createChangesAndLinesTable(
				new DirectoryColumn(),
				SORT_BY_LINES,
				Messages.getString("DIRECTORIES_TABLE_FOR_AUTHOR_SUMMARY"));
	}

	/**
	 * @see net.sf.statsvn.reports.TableReport#getTable()
	 */
	public Table getTable() {
		return table;
	}
}