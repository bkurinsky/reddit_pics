package com.basicapps.redditpics.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TypefaceHelper {

	/**
	 * Directory in which the fonts for the application will be stored.
	 */
	private static final String FONTS_DIR = "fonts/";
	
	/**
	 * An enum of the font typefaces that can be used throughout the application.
	 */
	public enum TypefaceName {
		
		VERDANA("verdana.ttf");
		
		private TypefaceName(String typefaceName) {
			this.typefaceName = typefaceName;
		}
		
		private String typefaceName;
		public String getTypefaceName() {
			return typefaceName;
		}
	}
	
	/**
	 * The actual {@link Typeface} objects.
	 */
	private static Typeface verdana = null;
	
	/**
	 * Private constructor.
	 */
	private TypefaceHelper() {
		// Private Constructor
	}
	
	/**
	 * Will apply the given typface to all views that match the given array of id's in the provided Activity.
	 * 
	 * @param activity the current {@link Activity} in which to search for view IDs
	 * @param typefaceName the {@link TypefaceName} to use for styling
	 * @param viewIds the view ids to style
	 */
	public static void applyTypeFaceToViewIds(Activity activity, TypefaceName typefaceName, int[] viewIds) {
		if ( viewIds != null && viewIds.length > 0) {
			for (int viewId : viewIds) {
				View view = activity.findViewById(viewId);
				if ( view != null ) {
					if ( view instanceof TextView || view instanceof Button ) {
						((TextView)view).setTypeface(getTypeface(activity, typefaceName));
					}
				}
			}
		}
	}
	
	/**
	 * Will apply the given typface to all views that match the given array of id's in the provided root view.
	 * 
	 * @param context the current application {@link Context}
	 * @param rootView the root {@link View} in which to search for other view IDs
	 * @param typefaceName the {@link TypefaceName} to use for styling
	 * @param viewIds the view ids to style
	 */
	public static void applyTypeFaceToViewIds(Context context, View rootView, TypefaceName typefaceName, int[] viewIds) {
		if ( viewIds != null && viewIds.length > 0) {
			for (int viewId : viewIds) {
				View view = rootView.findViewById(viewId);
				if ( view != null ) {
					if ( view instanceof TextView || view instanceof Button ) {
						((TextView)view).setTypeface(getTypeface(context, typefaceName));
					}
				}
			}
		}
	}
	
	/**
	 * Loads and returns the requested {@link Typeface} object given the {@link TypefaceName}.
	 * 
	 * @param context the current application {@link Context}
	 * @param typefaceName the name of the {@link Typeface} to use passed as a {@link TypefaceName} enum value
	 * @return a loaded {@link Typeface} object
	 */
	public static Typeface getTypeface(Context context, TypefaceName typefaceName) {
		
		switch(typefaceName) {
			case VERDANA:
				if ( verdana == null ) {
					verdana = createTypeface(context, TypefaceName.VERDANA.getTypefaceName());
				}
				return verdana;
				
			default:
				return Typeface.DEFAULT;
		}
	}
	
	/**
	 * Lods the {@link Typeface} object into memory given the appropriate 
	 * name from the {@link TypefaceName} enum value.
	 * 
	 * @param context the current application {@link Context}
	 * @param typefaceName the {@link TypefaceName} enum value
	 * @return a loaded {@link Typeface} object
	 */
	private static Typeface createTypeface(Context context, String typefaceName) {
		return Typeface.createFromAsset(context.getAssets(), FONTS_DIR + typefaceName);
	}
	
}
