package io.pure.sixgrid.drawer;

public class SortApps {
	public void exchange_sort(AppsActivity.Pac[] pacs){
		int i, j;
		AppsActivity.Pac temp;

		for ( i = 0;  i < pacs.length - 1;  i++ )
		{
			for ( j = i + 1;  j < pacs.length;  j++ )
			{  
				if ( pacs [ i ].label.compareToIgnoreCase( pacs [ j ].label ) > 0 )
				{                                             // ascending sort
					temp = pacs [ i ];
					pacs [ i ] = pacs [ j ];    // swapping
					pacs [ j ] = temp; 

				} 
			} 
		} 
	}
}
