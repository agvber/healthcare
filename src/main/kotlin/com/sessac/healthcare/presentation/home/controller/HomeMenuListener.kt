package com.sessac.healthcare.presentation.home.controller

/**
 * 컨트롤러에서 메뉴 이벤트를 리스닝 하기 때문에
 * 리스너 인터페이스를 사용해서 리스너 객체를 메인에서 처리함으로써 컨트롤러를 더 간결하게 구현.
 */
interface HomeMenuListener {
    fun onSelectRecord()
    fun onSelectGoal()
    fun onSelectUserInfo()
    fun onExit()
    fun onInvalidInput()
}