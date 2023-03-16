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

#if !defined(AFX_QUERYDLG_H__66EBB3C4_B0C3_11D2_ADC4_0000F8084273__INCLUDED_)
#define AFX_QUERYDLG_H__66EBB3C4_B0C3_11D2_ADC4_0000F8084273__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000
// QueryDlg.h : header file
//

/////////////////////////////////////////////////////////////////////////////
// QueryDlg dialog

class QueryDlg : public CDialog
{
// Construction
public:
	QueryDlg(CWnd* pParent = NULL);   // standard constructor

// Dialog Data
	//{{AFX_DATA(QueryDlg)
	enum { IDD = IDD_QUERYDLG };
		// NOTE: the ClassWizard will add data members here
	//}}AFX_DATA
	BOOL m_bCanceled;

// Overrides
	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(QueryDlg)
	protected:
	virtual void DoDataExchange(CDataExchange* pDX);    // DDX/DDV support
	//}}AFX_VIRTUAL

// Implementation
protected:

	// Generated message map functions
	//{{AFX_MSG(QueryDlg)
	virtual void OnOK();
	virtual void OnCancel();
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()
};

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_QUERYDLG_H__66EBB3C4_B0C3_11D2_ADC4_0000F8084273__INCLUDED_)
