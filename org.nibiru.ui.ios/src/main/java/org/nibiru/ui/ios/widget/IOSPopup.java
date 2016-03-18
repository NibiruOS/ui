package org.nibiru.ui.ios.widget;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.inject.Inject;

import org.moe.natj.general.Pointer;
import org.moe.natj.objc.ann.Selector;
import org.nibiru.ui.core.api.Popup;
import org.nibiru.ui.core.api.Widget;

import apple.coregraphics.struct.CGPoint;
import apple.coregraphics.struct.CGRect;
import apple.foundation.NSArray;
import apple.uikit.UIApplication;
import apple.uikit.UIColor;
import apple.uikit.UIView;
import apple.uikit.enums.UIViewAutoresizing;

public class IOSPopup implements Popup {
	private final Overlay overlay;
	private Widget content;

	@Inject
	public IOSPopup() {
		overlay = Overlay.alloc().init();
	}

	@Override
	public void setContent(Widget content) {
		checkNotNull(content);
		if (this.content != null) {
			this.content.setParent(null);
		}
		this.content = content;
		overlay.setContent((UIView) content.asNative());
		content.setParent(this);
		content.layout();
	}

	@Override
	public void show() {
		rootView().addSubview(overlay);
	}

	@Override
	public void hide() {
		overlay.hide();
	}

	@Override
	public void setAutoHide(boolean autoHide) {
		// TODO Auto-generated method stub
	}

	@Override
	public void requestLayout() {
		overlay.requestLayout();
	}

	@Override
	public void scheduleLayout() {
		requestLayout();
	}

	private static UIView rootView() {
		NSArray<? extends UIView> views = UIApplication.sharedApplication().keyWindow().subviews();
		return views.objectAtIndex(views.size() - 1);
	}

	private static class Overlay extends UIView {
		@Selector("alloc")
		public static native Overlay alloc();

		private UIView content;

		protected Overlay(Pointer peer) {
			super(peer);
		}

		public Overlay init() {
			super.initWithFrame(rootView().frame());
			// configurable bits
			setBackgroundColor(UIColor.blackColor());
			setAlpha(0.75);
			setAutoresizingMask(UIViewAutoresizing.FlexibleWidth | UIViewAutoresizing.FlexibleHeight);
			return this;

		}

		private void setContent(UIView content) {
			if (this.content != null) {
				this.content.removeFromSuperview();
			}
			this.content = content;
			requestLayout();
			addSubview(content);
		}

		private void requestLayout() {
			if (content != null) {
				content.setFrame(new CGRect(
						new CGPoint((frame().size().width() - content.frame().size().width()) / 2,
								(frame().size().height() - content.frame().size().height()) / 2),
						content.frame().size()));
			}
		}

		private void hide() {
			UIView.animateWithDurationAnimationsCompletion(0.5, // duration
					() -> {
						setAlpha(0);
					}, (boolean b) -> {
						removeFromSuperview();
					});
		}
	}
}
