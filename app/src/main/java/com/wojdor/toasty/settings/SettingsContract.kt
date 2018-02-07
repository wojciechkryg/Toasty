package com.wojdor.toasty.settings

import com.wojdor.toasty.base.BasePresenter
import com.wojdor.toasty.base.BaseView

interface SettingsContract {

    interface View : BaseView<Presenter>

    interface Presenter : BasePresenter
}