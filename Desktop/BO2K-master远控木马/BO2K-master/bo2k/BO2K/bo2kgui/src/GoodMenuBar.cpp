/*  Back Orifice 2000 - Remote Administration Suite
    Copyright (C) 1999, Cult Of The Dead Cow

    This program is free software; you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation; either version 2 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program; if not, write to the Free Software
    Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA

	The author of this program may be contacted at dildog@l0pht.com. */

// GoodMenuBar.cpp: implementation of the CGoodMenuBar class.
//
//////////////////////////////////////////////////////////////////////

#include "stdafx.h"
#include "bo2kgui.h"
#include "GoodMenuBar.h"

#ifdef _DEBUG
#undef THIS_FILE
static char THIS_FILE[]=__FILE__;
#define new DEBUG_NEW
#endif

//////////////////////////////////////////////////////////////////////
// Construction/Destruction
//////////////////////////////////////////////////////////////////////

CGoodMenuBar::CGoodMenuBar()
{
	
}

CGoodMenuBar::~CGoodMenuBar()
{

}

LRESULT CGoodMenuBar::WindowProc(UINT message,WPARAM wParam,LPARAM lParam)
{
	if(message==WM_NCPAINT) {
		CFrameWnd *frame=GetParentFrame();
		if(frame->IsKindOf(RUNTIME_CLASS(CMiniFrameWnd))) {
			frame->ModifyStyle(WS_SYSMENU,0,0);
		}
	}

	return CMenuBar::WindowProc(message,wParam,lParam);
}
