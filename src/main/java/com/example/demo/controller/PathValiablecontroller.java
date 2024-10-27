package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PathValiablecontroller {

	// GET かつ [URL: /show]
	@GetMapping("show")
	public String showView() {
		// 戻り値は「ビュー名」を返す
		return "show";
	}

	// GET かつ [/function/{no}]
	// ※{no}は動的に値が変わる

	/*show.htmlから/function/1~3を受け取る(この場合)
	アノテーションで受け取ることを定義して、メゾッドの引数で値を取り込む*/
	@GetMapping("/function/{no}")
	public String selectFunction(@PathVariable Integer no) {
		// ビュー名の初期化
		String view = null;

		switch (no) {
		case 1:
			view = "pathvaliable/function1";
			break;
		case 2:
			view = "pathvaliable/function2";
			break;
		case 3:
			view = "pathvaliable/function3";
			break;
		}

		// 戻り値は「ビュー名」を返す
		return view;
	}

	/** ボタンA押下処理 */
	@PostMapping(value = "send", params = "a")
	public String showAView() {
		// 戻り値は「ビュー名」を返します
		return "submit/a";
	}

	/** ボタンB押下処理 */
	@PostMapping(value = "send", params = "b")
	public String showBView() {
		// 戻り値は「ビュー名」を返します
		return "submit/b";
	}

	/** ボタンC押下処理 */
	@PostMapping(value = "send", params = "c")
	public String showCView() {
		// 戻り値は「ビュー名」を返します
		return "submit/c";
	}
}